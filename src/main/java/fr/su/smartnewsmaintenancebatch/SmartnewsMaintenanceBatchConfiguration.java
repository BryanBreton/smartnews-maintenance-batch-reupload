package fr.su.smartnewsmaintenancebatch;

import fr.su.smartnewsmaintenancebatch.service.processor.ExempleProcessor;
import fr.su.smartnewsmaintenancebatch.service.reader.ExempleReader;
import fr.su.smartnewsmaintenancebatch.service.writer.ExempleWriter;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.DefaultBatchConfigurer;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.repository.JobRepository;
import org.springframework.batch.core.repository.support.MapJobRepositoryFactoryBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import lombok.AllArgsConstructor;

@Configuration
@EnableBatchProcessing
@EnableTransactionManagement
@AllArgsConstructor
public class SmartnewsMaintenanceBatchConfiguration extends DefaultBatchConfigurer {

    private final JobBuilderFactory jobBuilderFactory;

    private final StepBuilderFactory stepBuilderFactory;

    /**
     * Cette surcharge permet de persister les meta tables de spring batch en
     * mémoire au lieu de la BDD
     **/
    @Override
    protected JobRepository createJobRepository() throws Exception {
        MapJobRepositoryFactoryBean factoryBean = new MapJobRepositoryFactoryBean();
        factoryBean.afterPropertiesSet();
        return factoryBean.getObject();
    }

    @Bean
    public Job extractSomething() throws Exception {

        return jobBuilderFactory.get("jobExemple")
                .start(reader())
                .next(processor())
                .next(writer())
                .build();
    }

    @Bean
    public Step reader() throws Exception {
        return stepBuilderFactory.get("reader").tasklet(exempleReader()).build();
    }

    @Bean
    public Step processor() {
        return stepBuilderFactory.get("processor").tasklet(exempleProcessor()).build();
    }

    @Bean
    public Step writer() {
        return stepBuilderFactory.get("writer").tasklet(exempleWriter()).build();
    }

    @Bean
    public ExempleReader exempleReader() throws Exception {
        return new ExempleReader();
    }

    @Bean
    public ExempleProcessor exempleProcessor() {
        return new ExempleProcessor();
    }

    @Bean
    public ExempleWriter exempleWriter() {
        return new ExempleWriter();
    }
}
