package me.janeve.java12.compact_number_formatting;

import java.text.NumberFormat;
import java.util.Arrays;
import java.util.Locale;

/*
    The Compact Numbering Format was introduced in Java 12.
    This code provides an example of how format numbers based on various locales that are available.
 */
public class CompactNumberFormattingExamples {

    public static void main(String[] args) {
        Arrays.asList(
                Locale.getAvailableLocales()
        ).forEach(
            locale -> {
                printFormattedNumbers(locale, NumberFormat.Style.SHORT);
                printFormattedNumbers(locale, NumberFormat.Style.LONG);
            }
        );
    }

    private static void printFormattedNumbers(Locale locale, NumberFormat.Style style) {
        System.out.println(getTitle(style.name(), locale));
        NumberFormat formatter = NumberFormat.getCompactNumberInstance(locale, style);
        System.out.println("1                     :" + formatter.format(1));
        System.out.println("2000                  :" + formatter.format(2000));
        System.out.println("2345                  :" + formatter.format(2345));
        System.out.println("30,000                :" + formatter.format(30_000));
        System.out.println("34,567                :" + formatter.format(34_567));
        System.out.println("4,000,000             :" + formatter.format(4_000_000));
        System.out.println("4,00,00,000           :" + formatter.format(4_00_00_000));
        System.out.println("5,000,000,000         :" + formatter.format(5_000_000_000L));
        System.out.println("60,000,000,000        :" + formatter.format(60_000_000_000L));
        System.out.println("7,000,000,000,000     :" + formatter.format(7_000_000_000_000L));
    }


    private static String getTitle(String style, Locale locale) {
        String title =  "\n\n     " + style + " FORMATTING ("  + locale.getDisplayName() + ")";
        return title + "\n"+ "=".repeat(title.length()+4);
    }
}