package com.eqt.dataenrichment.infrastructure;

import com.eqt.dataenrichment.infrastructure.model.divestment.DivestmentCompanyResponse;
import com.eqt.dataenrichment.infrastructure.model.portfolio.PortfolioCompanyResponse;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;

@Component
public class EqtWebClient {

    private final WebClient webClient;
    private final String portfolioUrl;
    private final String divestmentUrl;

    public EqtWebClient(@Value("${EQT_CLIENT.BASE_URL}") final String baseUrl,
                        @Value("${EQT_CLIENT.PORTFOLIO_URL}") final String portfolioUrl,
                        @Value("${EQT_CLIENT.DIVESTMENT_URL}") final String divestmentUrl) {
        this.webClient = WebClient.builder()
                .baseUrl(baseUrl)
                .defaultHeader(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
                .build();
        this.portfolioUrl = portfolioUrl;
        this.divestmentUrl = divestmentUrl;
    }

    public PortfolioCompanyResponse fetchPortfolioCompanies() {
        return webClient.get()
                .uri(portfolioUrl)
                .retrieve()
                .bodyToMono(PortfolioCompanyResponse.class)
                .block();
    }

    public DivestmentCompanyResponse fetchDivestmentCompanies() {
        return webClient.get()
                .uri(divestmentUrl)
                .retrieve()
                .bodyToMono(DivestmentCompanyResponse.class)
                .block();
    }
}
