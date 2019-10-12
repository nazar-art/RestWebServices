package com.lelyak.database;

import com.google.common.collect.Maps;
import com.lelyak.model.Message;
import com.lelyak.model.Profile;

import java.util.Map;


public final class DatabaseMock {

    private static Map<Long, Message> messages = Maps.newHashMap();
    private static Map<String, Profile> profiles = Maps.newHashMap();

    public static Map<Long, Message> getMessages() {
        return messages;
    }

    public static Map<String, Profile> getProfiles() {
        return profiles;
    }
}
