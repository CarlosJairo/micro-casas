package com.Hogar360.casas.infrastructure.adapters.persistence;

import com.Hogar360.casas.domain.model.CategoryModel;
import com.Hogar360.casas.domain.ports.out.CategoryPersistencePort;
import com.Hogar360.casas.domain.utils.pagination.Pagination;
import com.Hogar360.casas.infrastructure.entities.CategoryEntity;
import com.Hogar360.casas.infrastructure.mappers.CategoryEntityMapper;
import com.Hogar360.casas.infrastructure.repositories.mysql.CategoryRepository;
import com.Hogar360.casas.commons.configurations.utils.Constants;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class CategoryServiceAdapter implements CategoryPersistencePort {
    private final CategoryRepository categoryRepository;
    private final CategoryEntityMapper categoryEntityMapper;

    @Override
    public void saveCategory(CategoryModel categoryModel) {
        categoryRepository.save(categoryEntityMapper.modelToEntity(categoryModel));
    }

    @Override
    public CategoryModel getCategoryByName(String categoryName) {
        return categoryEntityMapper.entityToModel(categoryRepository.findByName(categoryName).orElse(null));
    }

    @Override
    public Pagination<CategoryModel> getCategories(Integer page, Integer size, boolean orderAsc) {
        Pageable pageable = PageRequest.of(page, size,
                orderAsc ?
                        Sort.by(Constants.PAGEABLE_FIELD_NAME).ascending() :
                        Sort.by(Constants.PAGEABLE_FIELD_NAME).descending());

        Page<CategoryEntity> pageResult = categoryRepository.findAll(pageable);
        List<CategoryModel> models = pageResult.getContent().stream()
                .map(categoryEntityMapper::entityToModel)
                .toList();

        return new Pagination<>(
                models,
                pageResult.getTotalElements(),
                pageResult.getTotalPages(),
                pageResult.getSize(),
                pageResult.getNumber()
        );
    }
}
