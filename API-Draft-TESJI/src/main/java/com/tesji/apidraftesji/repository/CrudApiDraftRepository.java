package com.tesji.apidraftesji.repository;

import com.tesji.apidraftesji.model.DatosApiDraft;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CrudApiDraftRepository extends CrudRepository<DatosApiDraft,Long> {
}
