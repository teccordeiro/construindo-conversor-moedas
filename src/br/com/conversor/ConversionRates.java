package br.com.conversor;

import com.google.gson.annotations.SerializedName;

public record ConversionRates(@SerializedName("base_code") String moedaOrigemBasecode,
                              @SerializedName("target_code") String moedaDestinoTargetCode,
                              @SerializedName("conversion_rate") double conversion_rate) {
}
