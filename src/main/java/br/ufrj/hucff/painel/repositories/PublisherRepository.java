package br.ufrj.hucff.painel.repositories;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import br.ufrj.hucff.painel.modelo.Pubisher;

public interface PublisherRepository extends JpaRepository<Pubisher, UUID> {

}
