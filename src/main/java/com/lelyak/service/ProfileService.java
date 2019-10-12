package com.lelyak.service;

import com.lelyak.database.DatabaseMock;
import com.lelyak.model.Profile;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class ProfileService {

    private Map<String, Profile> allProfiles = DatabaseMock.getProfiles();

    public ProfileService() {
        allProfiles.put("lelyak",
                new Profile(1L, "lelyak", "Nazar", "Lelyak")
        );
        allProfiles.put("admin",
                new Profile(2L, "admin", "Admin", "StrongAdmin")
        );
    }

    public List<Profile> getAllProfiles() {
        return new ArrayList<>(allProfiles.values());
    }

    public Profile getProfile(String profileName) {
        return allProfiles.get(profileName);
    }

    public Profile addProfile(Profile profile) {
        profile.setId(allProfiles.size() + 1);
        allProfiles.put(profile.getProfileName(), profile);
        return profile;
    }

    public Profile updateProfile(Profile profile) {
        if (profile.getProfileName().isEmpty()) {
            return null;
        }
        allProfiles.put(profile.getProfileName(), profile);
        return profile;
    }

    public Profile removeProfile(String profileName) {
        return allProfiles.remove(profileName);
    }
}
