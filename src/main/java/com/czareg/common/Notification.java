package com.czareg.common;

import java.time.Instant;

public record Notification(Instant instant, String text) {
}
