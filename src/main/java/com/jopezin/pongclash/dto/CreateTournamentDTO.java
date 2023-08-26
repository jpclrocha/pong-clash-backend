package com.jopezin.pongclash.dto;

import java.util.UUID;

public record CreateTournamentDTO(String name, UUID teamId) {
}
