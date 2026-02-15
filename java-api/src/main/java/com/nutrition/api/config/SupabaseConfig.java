package com.nutrition.api.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.beans.factory.annotation.Value;
import io.supabase.Postgrest;
import io.supabase.SupabaseClient;
import io.supabase.SupabaseOptions;
import io.supabase.impl.SupabaseClientImpl;

@Configuration
public class SupabaseConfig {

    @Value("${supabase.url:}")
    private String supabaseUrl;

    @Value("${supabase.key:}")
    private String supabaseKey;

    @Bean
    public SupabaseClient supabaseClient() {
        if (supabaseUrl != null && !supabaseUrl.isEmpty() && supabaseKey != null && !supabaseKey.isEmpty()) {
            return new SupabaseClientImpl(supabaseUrl, supabaseKey, SupabaseOptions.builder().build());
        }
        return null; // Return null if not configured, fallback to in-memory
    }

    @Bean
    public Postgrest postgrest() {
        SupabaseClient client = supabaseClient();
        return client != null ? client.from("users") : null;
    }
}