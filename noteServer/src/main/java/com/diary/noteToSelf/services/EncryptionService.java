package com.diary.noteToSelf.services;

public interface EncryptionService {
    public String encrypt(String content, String key) throws Exception;

    public String decrypt(String content, String key) throws Exception;
}
