package com.board.config;

import com.board.domain.UserAccount;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.rest.webmvc.config.RepositoryRestConfigurer;

/**
 * Spring Data REST 추가 설정 - userId 노출
 */
@Configuration
public class DataRestConfig {

    @Bean
    public RepositoryRestConfigurer repositoryRestConfigurer() {
        return RepositoryRestConfigurer.withConfig((config, cors) -> config.exposeIdsFor(UserAccount.class));
    }

}
