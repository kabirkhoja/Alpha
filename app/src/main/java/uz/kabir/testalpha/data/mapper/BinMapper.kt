package uz.kabir.testalpha.data.mapper

import uz.kabir.testalpha.data.local.BinEntity
import uz.kabir.testalpha.data.model.BinResponse
import uz.kabir.testalpha.domain.model.BinData

fun BinResponse.toDomain(bin: String): BinData {
    return BinData(
        bin = bin,
        scheme = scheme,
        type = type,
        brand = brand,
        prepaid = prepaid,
        cardLength = number?.length,
        luhn = number?.luhn,
        countryName = country?.name,
        countryEmoji = country?.emoji,
        currency = country?.currency,
        latitude = country?.latitude,
        longitude = country?.longitude,
        bankName = bank?.name,
        bankUrl = bank?.url,
        bankPhone = bank?.phone,
        bankCity = bank?.city,
        timestamp = System.currentTimeMillis()
    )
}

fun BinEntity.toDomain(): BinData {
    return BinData(
        bin = bin,
        scheme = scheme,
        type = type,
        brand = brand,
        prepaid = prepaid,
        cardLength = cardLength,
        luhn = luhn,
        countryName = countryName,
        countryEmoji = countryEmoji,
        currency = currency,
        latitude = latitude,
        longitude = longitude,
        bankName = bankName,
        bankUrl = bankUrl,
        bankPhone = bankPhone,
        bankCity = bankCity,
        timestamp = timestamp
    )
}

fun BinData.toEntity(): BinEntity {
    return BinEntity(
        bin = bin,
        scheme = scheme,
        type = type,
        brand = brand,
        prepaid = prepaid,
        cardLength = cardLength,
        luhn = luhn,
        countryName = countryName,
        countryEmoji = countryEmoji,
        currency = currency,
        latitude = latitude,
        longitude = longitude,
        bankName = bankName,
        bankUrl = bankUrl,
        bankPhone = bankPhone,
        bankCity = bankCity,
        timestamp = timestamp
    )
}

