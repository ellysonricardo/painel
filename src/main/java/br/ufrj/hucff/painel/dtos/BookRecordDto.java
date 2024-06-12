package br.ufrj.hucff.painel.dtos;

import java.util.Set;
import java.util.UUID;

public record BookRecordDto(String title, UUID publisherId, Set<UUID> autorIds, String reviewComment) {

}
