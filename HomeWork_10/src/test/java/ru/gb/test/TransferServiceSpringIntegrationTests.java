package ru.gb.test;

import ru.gb.test.model.Account;
import ru.gb.test.repositories.AccountRepository;
import ru.gb.test.services.TransferService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.math.BigDecimal;
import java.util.Optional;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
/**
 * TransferServiceSpringIntegrationTests - класс, реализующий интеграционное тестирование функционала,
 * обеспечивающего перевод денежных средств с одного счета на другой.
 */
@SpringBootTest
class TransferServiceSpringIntegrationTests {
    @MockBean                                      // Создание копии объекта для тестирования
    private AccountRepository accountRepository;
    @Autowired                                     // Обертка для аккаунт-репозитория, работающего с БД
    private TransferService transferService;

    @Test
    @DisplayName("Тест на проверку правильности суммы перевода с одного счета на другой.")
    void transferServiceTransferAmountTest() {
        // Arrange: начальные условия для тестирования
        Account sender = new Account();                                               // Данные по счету отправителя
        sender.setId(1);                                                              // № счета
        sender.setAmount(new BigDecimal(1000));                                   // Объем денежных средств

        Account receiver = new Account();                                             // Данные по счету получателя
        receiver.setId(2);
        receiver.setAmount(new BigDecimal(1000));

        when(accountRepository.findById(1L)).thenReturn(Optional.of(sender));          // Перевод
        when(accountRepository.findById(2L)).thenReturn(Optional.of(receiver));        // Получение

        // Act: проверяемое действие
        transferService.transferMoney(1, 2, new BigDecimal(100)); // Перевод на счет 100 у.е.

        // Assert: проверка результата тестирования
        verify(accountRepository).changeAmount(1, new BigDecimal(900));         // Списание со счета отправителя
        verify(accountRepository).changeAmount(2, new BigDecimal(1100));        // Начисление на счет получателя
    }
}
