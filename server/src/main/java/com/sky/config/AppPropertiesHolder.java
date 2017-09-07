package com.sky.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.NestedConfigurationProperty;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix = "application")
public class AppPropertiesHolder {

    @NestedConfigurationProperty
    private MeteoData meteoData;

    public static class MeteoData {
        @NestedConfigurationProperty
        private Api api;
        private String apiKey;

        public static class Api {
            @NestedConfigurationProperty
            private Uri uri;
            @NestedConfigurationProperty
            private Params params;

            public static class Uri {
                private String currentMeteoData;

                public String getCurrentMeteoData() {
                    return currentMeteoData;
                }

                public void setCurrentMeteoData(String currentMeteoData) {
                    this.currentMeteoData = currentMeteoData;
                }
            }

            public static class Params {
                private String city;
                private String apiKey;

                public String getCity() {
                    return city;
                }

                public void setCity(String city) {
                    this.city = city;
                }

                public String getApiKey() {
                    return apiKey;
                }

                public void setApiKey(String apiKey) {
                    this.apiKey = apiKey;
                }
            }

            public Uri getUri() {
                return uri;
            }

            public void setUri(Uri uri) {
                this.uri = uri;
            }

            public Params getParams() {
                return params;
            }

            public void setParams(Params params) {
                this.params = params;
            }
        }

        public Api getApi() {
            return api;
        }

        public void setApi(Api api) {
            this.api = api;
        }

        public String getApiKey() {
            return apiKey;
        }

        public void setApiKey(String accessKey) {
            this.apiKey = accessKey;
        }
    }

    public MeteoData getMeteoData() {
        return meteoData;
    }

    public void setMeteoData(MeteoData meteoData) {
        this.meteoData = meteoData;
    }

}
