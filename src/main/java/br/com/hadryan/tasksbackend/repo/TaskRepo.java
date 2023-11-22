package br.com.hadryan.tasksbackend.repo;

import br.com.hadryan.tasksbackend.model.Task;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TaskRepo extends JpaRepository<Task, Long> {
}
