package com.javaindoku.www.yotaniserikatkerja.utilities;

import androidx.annotation.InspectableProperty;

import java.lang.annotation.Annotation;

public enum SharedPrefKeys implements InspectableProperty.EnumEntry {
    userId,
    sharedName,
    userName,
    fullName,
    noHp,
    email,
    rekomendasi,
    photoProfile,
    alamat,
    expectedSalary,
    agentId,
    isLogin,
    isRememberMe,
    jobName,
    jobLocation,
    salaryMin,
    minDataShow,
    sortBy,
    tglPosting,
    tingkatPengalaman,
    lokasi,
    jobType,
    isAgent;

    @Override
    public int value() {
        return 0;
    }

    @Override
    public Class<? extends Annotation> annotationType() {
        return null;
    }
}
