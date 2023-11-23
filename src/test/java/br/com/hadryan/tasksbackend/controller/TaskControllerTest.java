package br.com.hadryan.tasksbackend.controller;

import br.com.hadryan.tasksbackend.model.Task;
import br.com.hadryan.tasksbackend.repo.TaskRepo;
import br.com.hadryan.tasksbackend.utils.ValidationException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

class TaskControllerTest {

    @Mock
    private TaskRepo taskRepo;

    @InjectMocks
    private TaskController controller;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.openMocks(this);
    }

    @Test()
    public void naoDeveSalvarTarefaSemDescricao() {
        Task todo = new Task();
        todo.setDueDate(LocalDate.now());
        try {
            controller.save(todo);
            fail("Não deveria chegar neste ponto");
        } catch (ValidationException e) {
            assertEquals("Fill the task description", e.getMessage());
        }

    }

    @Test
    public void naoDeveSalvarTarefaSemData() {
        Task todo = new Task();
        todo.setTask("Teste");
        try {
            controller.save(todo);
            fail("Não deveria chegar neste ponto");
        } catch (ValidationException e) {
            assertEquals("Fill the due date", e.getMessage());
        }
    }


    @Test
    public void naoDeveSalvarTarefaComDataPassada() {
        Task todo = new Task();
        todo.setTask("Teste");
        todo.setDueDate(LocalDate.of(2001, 01, 01));
        try {
            controller.save(todo);
            fail("Não deveria chegar neste ponto");
        } catch (ValidationException e) {
            assertEquals("Due date must not be in past", e.getMessage());
        }
    }

    @Test
    public void deveSalvarTarefaComSucesso() throws ValidationException {
        Task todo = new Task();
        todo.setTask("Teste");
        todo.setDueDate(LocalDate.now());
        controller.save(todo);
    }

}