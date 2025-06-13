package org.example.enums;


import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public enum Currency {
    RUB("RUB"),
    USD("USD"),
    EUR("EUR"),
    CNY("CNY");

    private final String currency;

    public static boolean containsValue(String currency) {
        return java.util.Arrays.stream(Currency.values())
                .anyMatch(c -> c.currency.equalsIgnoreCase(currency));
    }
}
