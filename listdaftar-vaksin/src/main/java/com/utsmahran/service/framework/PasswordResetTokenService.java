package com.utsmahran.service.framework;

import com.utsmahran.entity.PasswordResetToken;


public interface PasswordResetTokenService {
    PasswordResetToken findByToken(String token);

    PasswordResetToken save(PasswordResetToken passwordResetToken);
}
