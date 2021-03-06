/**
 *    Copyright 2019 MetaRing s.r.l.
 *
 *    Licensed under the Apache License, Version 2.0 (the "License");
 *    you may not use this file except in compliance with the License.
 *    You may obtain a copy of the License at
 *
 *        http://www.apache.org/licenses/LICENSE-2.0
 *
 *    Unless required by applicable law or agreed to in writing, software
 *    distributed under the License is distributed on an "AS IS" BASIS,
 *    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *    See the License for the specific language governing permissions and
 *    limitations under the License.
 */

package com.metaring.framework.crypto;

import java.util.concurrent.CompletableFuture;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;

import com.metaring.framework.Core;
import com.metaring.framework.type.DataRepresentation;
import com.metaring.framework.util.CryptoUtil;

final class DecryptFunctionalityImpl extends DecryptFunctionality {

    static final String CFG_CRYPTO = "crypto";
    static final String CFG_CRYPTO_ALGORYTHM = "algorythm";
    static final String CFG_CRYPTO_KEY = "key";

    private static final Cipher CIPHER;

    static {
        DataRepresentation crypto = Core.SYSKB.get(CFG_CRYPTO);
        Cipher cipher = null;
        try {
            cipher = Cipher.getInstance(crypto.getText(CFG_CRYPTO_ALGORYTHM));
            byte[] keyBytesFromString = CryptoUtil.BASE_64_DECODER.decode(crypto.getText(CFG_CRYPTO_KEY));
            cipher.init(Cipher.DECRYPT_MODE, new SecretKeySpec(keyBytesFromString, 0, keyBytesFromString.length, "DES"));
        } catch (Exception e) {
        }
        CIPHER = cipher;
    }

    @Override
    protected CompletableFuture<Void> preConditionCheck(String input) throws Exception {
        return end;
    }

    @Override
    protected CompletableFuture<String> call(String input) throws Exception {
        if(input == null) {
            return end(null);
        }
        return end(new String(CIPHER.doFinal(CryptoUtil.BASE_64_DECODER.decode(input))));
    }

    @Override
    protected CompletableFuture<Void> postConditionCheck(String input, String output) throws Exception {
        return end;
    }

}
