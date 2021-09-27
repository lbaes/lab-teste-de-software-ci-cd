import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.*;

class ClienteTest {

    @ParameterizedTest(name = "{0} pode ser emprestado")
    @ValueSource(ints = {1001, 2000, 5000})
    void podePegarEmprestado_QuandoSaldoMaiorQue1000ENaoConcessao_RetornaTrue(int saldo) {
        Cliente cliente = new Cliente(saldo, false);

        var actual = cliente.PodePegarEmprestado(false);

        assertTrue(actual);
    }

    @ParameterizedTest(name = "{0} pode ser emprestado")
    @ValueSource(ints = {900, 800, 100})
    void podePegarEmprestado_QuandoSaldoMenorQue1000eEhConcessao_RetornaTrue(int saldo) {
        Cliente cliente = new Cliente(saldo, false);

        var actual = cliente.PodePegarEmprestado(true);

        assertTrue(actual);
    }

    @ParameterizedTest(name = "{0} pode ser emprestado")
    @ValueSource(ints = {100, 200, 300})
    void podePegarEmprestado_QuandoSaldoMenorQue1000eNaoConcessaoEBomPagador_RetornaTrue(int saldo) {
        Cliente cliente = new Cliente(saldo, true);

        var actual = cliente.PodePegarEmprestado(false);

        assertTrue(actual);
    }

    @ParameterizedTest(name = "{0} pode ser emprestado")
    @ValueSource(ints = {0, 15, 68})
    void podePegarEmprestado_QuandoSaldoMenorQue1000eNaoConcessaoEnaoPagador_RetornaFalse(int saldo) {
        Cliente cliente = new Cliente(saldo, false);

        var actual = cliente.PodePegarEmprestado(false);

        assertFalse(actual);
    }

}