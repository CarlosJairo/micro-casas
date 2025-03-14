package com.Hogar360.casas.category.infrastructure.adapters.persistence;

import com.Hogar360.casas.category.domain.model.CategoryModel;
import com.Hogar360.casas.category.domain.ports.out.CategoryPersistencePort;
import com.Hogar360.casas.category.infrastructure.mappers.CategoryEntityMapper;
import com.Hogar360.casas.category.infrastructure.repositories.mysql.CategoryRepository;
import com.Hogar360.casas.commons.configurations.utils.Constants;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
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
    public List<CategoryModel> getCategories(Integer page, Integer size, boolean orderAsc) {
        Pageable pagination;
        if (orderAsc) {
            pagination = PageRequest.of(page, size, Sort.by(Constants.PAGEABLE_FIELD_NAME).ascending());
        } else {
            pagination = PageRequest.of(page, size, Sort.by(Constants.PAGEABLE_FIELD_NAME).descending());
        }
        return categoryEntityMapper.entityListToModelList(categoryRepository.findAll(pagination).getContent());
    }
}
