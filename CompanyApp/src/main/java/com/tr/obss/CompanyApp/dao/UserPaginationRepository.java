package com.tr.obss.CompanyApp.dao;

import com.tr.obss.CompanyApp.entity.User;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface UserPaginationRepository extends PagingAndSortingRepository<User, Long> {


}
