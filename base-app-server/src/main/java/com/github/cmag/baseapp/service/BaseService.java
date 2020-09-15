package com.github.cmag.baseapp.service;

import com.github.cmag.baseapp.dto.BaseDTO;
import com.github.cmag.baseapp.mapper.BaseMapper;
import com.github.cmag.baseapp.model.BaseEntity;
import com.github.cmag.baseapp.repository.BaseRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * A base Spring {@link Service}.
 *
 * @param <D> A DTO that extends the BaseDTO.
 * @param <E> An Entity that extends the BaseEntity.
 */
@Service
public abstract class BaseService<D extends BaseDTO, E extends BaseEntity> {

  @Autowired
  private BaseRepository<E> baseRepository;

  @Autowired
  private BaseMapper<D, E> mapper;

  /**
   * Find all the data matching the given Entity.
   *
   * @return A list of DTO representations of the matched Entities.
   */
  public List<D> findAll() {
    return mapper.mapToDTOs(baseRepository.findAll());
  }

}
