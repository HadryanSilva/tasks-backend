package br.com.hadryan.tasksbackend.utils;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class DateUtilsTest {

    @Test
    public void deveRetornarTrueParaDatasFuturas() {
        LocalDate date = LocalDate.of(2030, 01, 01);
        boolean dataFutura = DateUtils.isEqualOrFutureDate(date);
        assertTrue(dataFutura);
    }

    @Test
    public void deveRetornarFalseParaDatasPassadas() {
        LocalDate date = LocalDate.of(2021, 01, 01);
        boolean dataPassada = DateUtils.isEqualOrFutureDate(date);
        assertFalse(dataPassada);
    }

    @Test
    public void deveRetornarTrueParaDataAtual() {
        LocalDate date = LocalDate.now();
        boolean dataAtual = DateUtils.isEqualOrFutureDate(date);
        assertTrue(dataAtual);
    }

}