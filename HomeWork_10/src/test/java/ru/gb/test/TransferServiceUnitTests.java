package ru.gb.test;

import ru.gb.test.model.Account;
import ru.gb.test.repositories.AccountRepository;
import ru.gb.test.services.TransferService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.Optional;

import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class TransferServiceUnitTests {
    @Test
    @DisplayName("Тест на корректность перевода денежных средств с одного счета на другой.")
    public void moneyTransferHappyFlow() {
        // Arrange: начальные условия для тестирования
        AccountRepository accountRepository = mock(AccountRepository.class);           // Заглушка
        TransferService transferService = new TransferService(accountRepository);      // Создание тестового запроса

        Account sender = new Account();                                                // Добавление данных по счету
        sender.setId(1);                                                               // - отправителю платежа
        sender.setAmount(new BigDecimal(1000));

        Account destination = new Account();                                           // Добавление данных по счету
        destination.setId(2);                                                          // - получателю платежа
        destination.setAmount(new BigDecimal(1000));

        given(accountRepository.findById(sender.getId()))                              // Операция перевода
                .willReturn(Optional.of(sender));                                      // с ожидаемым значением

        given(accountRepository.findById(destination.getId()))                         // Операция получения
                .willReturn(Optional.of(destination));                                 // с ожидаемым значением

        // Act: проверяемое действие
        transferService.transferMoney(1, 2, new BigDecimal(100)); // Перевод 100 у.е.

        // Assert: проверка результата тестирования
        verify(accountRepository).changeAmount(1, new BigDecimal(900));         // Остаток средств на 1 счете
        verify(accountRepository).changeAmount(2, new BigDecimal(1100));        // Остаток средств на 2 счете
    }
}
