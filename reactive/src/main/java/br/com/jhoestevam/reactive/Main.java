package br.com.jhoestevam.reactive;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class Main {

    public static void main(String[] args) {
        System.out.println("vraaaw Luiz");

        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd HH:mm:ss");
        System.out.println(sdf.format(new Date()));


        Double dbl1 = 0.1d;
        Double dbl2 = 0.1d;
        Double dbl3 = 0.1d;

        Double dblSoma = (dbl1 + dbl2 + dbl3);

        System.out.println("Soma double -> " + dblSoma);

        Float flt1 = 0.1f;
        Float flt2 = 0.1f;
        Float flt3 = 0.1f;

        Float fltSoma = (flt1 + flt2 + flt3);

        System.out.println("Soma float -> " + fltSoma);

        BigDecimal big1 = BigDecimal.valueOf(0.33d);
        BigDecimal big2 = BigDecimal.valueOf(0.33d);
        BigDecimal big3 = BigDecimal.valueOf(0.33d);

        BigDecimal bigSoma = big1.add(big2).add(big3).multiply(new BigDecimal(10d)).setScale(10, RoundingMode.HALF_EVEN);

        DecimalFormatSymbols otherSymbols = new DecimalFormatSymbols(Locale.US);

        DecimalFormat df = new DecimalFormat();
        df.setDecimalFormatSymbols(otherSymbols);
        df.setMaximumFractionDigits(10);
        df.setMinimumFractionDigits(10);

        System.out.println("Soma big -> " + df.format(bigSoma));
    }

}
