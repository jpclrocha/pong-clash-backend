package com.jopezin.pongclash.dto;

import java.util.UUID;

public record CreateTeamDTO(String name, String acronym, UUID ownerId) {
}
