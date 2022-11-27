package fr.su.smartnewsmaintenancebatch.service.reader;

import lombok.NoArgsConstructor;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.batch.core.ExitStatus;
import org.springframework.batch.core.StepContribution;
import org.springframework.batch.core.StepExecution;
import org.springframework.batch.core.StepExecutionListener;
import org.springframework.batch.core.scope.context.ChunkContext;
import org.springframework.batch.core.step.tasklet.Tasklet;
import org.springframework.batch.repeat.RepeatStatus;

@NoArgsConstructor
public class ExempleReader implements Tasklet, StepExecutionListener {

    private static final Logger LOGGER = LogManager.getLogger(ExempleReader.class);

    @Override
    public void beforeStep(StepExecution stepExecution) {
        LOGGER.info("Start reader");
    }

    @Override
    public RepeatStatus execute(StepContribution contribution, ChunkContext chunkContext) throws Exception {
        LOGGER.info("Execute reader");
        return RepeatStatus.FINISHED;
    }

    @Override
    public ExitStatus afterStep(StepExecution stepExecution) {
        LOGGER.info("Afterstep reader");
        return ExitStatus.COMPLETED;
    }

}
