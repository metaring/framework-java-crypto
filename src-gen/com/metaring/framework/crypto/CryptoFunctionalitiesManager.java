package com.metaring.framework.crypto;

import com.metaring.framework.functionality.FunctionalityInfo;
import com.metaring.framework.functionality.FunctionalitiesManager;
import com.metaring.framework.functionality.GeneratedFunctionalitiesManager;
import com.metaring.framework.functionality.Functionality;
import java.util.concurrent.CompletableFuture;
import java.lang.String;

public class CryptoFunctionalitiesManager extends FunctionalitiesManager implements GeneratedFunctionalitiesManager {

    public static final FunctionalityInfo DECRYPT = FunctionalityInfo.create("com.metaring.framework.crypto.decrypt", true, false, false, "java.lang.String", "java.lang.String");

    public static final FunctionalityInfo ENCRYPT = FunctionalityInfo.create("com.metaring.framework.crypto.encrypt", true, false, false, "java.lang.String", "java.lang.String");

    public static final CompletableFuture<String> decrypt(String string) {
        return call(DECRYPT, DecryptFunctionality.class, getCallingFunctionality(), string, result -> result.asText());
    }

    public static final CompletableFuture<String> decrypt(Functionality functionality, String string) {
        return call(DECRYPT, DecryptFunctionality.class, functionality, string, result -> result.asText());
    }

    public static final CompletableFuture<String> decryptFromJson(String stringJson) {
        return callFromJson(DECRYPT, DecryptFunctionality.class, getCallingFunctionality(), stringJson, result -> result.asText());
    }

    public static final CompletableFuture<String> decryptFromJson(Functionality callingFunctionality, String stringJson) {
        return callFromJson(DECRYPT, DecryptFunctionality.class, callingFunctionality, stringJson, result -> result.asText());
    }

    public static final CompletableFuture<String> encrypt(String string) {
        return call(ENCRYPT, EncryptFunctionality.class, getCallingFunctionality(), string, result -> result.asText());
    }

    public static final CompletableFuture<String> encrypt(Functionality functionality, String string) {
        return call(ENCRYPT, EncryptFunctionality.class, functionality, string, result -> result.asText());
    }

    public static final CompletableFuture<String> encryptFromJson(String stringJson) {
        return callFromJson(ENCRYPT, EncryptFunctionality.class, getCallingFunctionality(), stringJson, result -> result.asText());
    }

    public static final CompletableFuture<String> encryptFromJson(Functionality callingFunctionality, String stringJson) {
        return callFromJson(ENCRYPT, EncryptFunctionality.class, callingFunctionality, stringJson, result -> result.asText());
    }

}
