package com.ghca.ceip.security.repository.impl;

import com.ghca.ceip.security.entity.User;
import com.ghca.ceip.security.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.support.JpaEntityInformation;
import org.springframework.data.jpa.repository.support.SimpleJpaRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.provisioning.UserDetailsManager;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

/**
 * Created by gh on 2017/4/12.
 */
public class UserRepositoryImpl extends SimpleJpaRepository<User, String> implements UserRepository {

    private final EntityManager entityManager;


    public UserRepositoryImpl(EntityManager em) {
        super(User.class, em);
        this.entityManager = em;
    }
    @Override
    public void createUser(UserDetails user) {
        save(checkUserDetails(user));
    }

    @Override
    public void updateUser(UserDetails user) {
        save(checkUserDetails(user));
    }

    @Override
    public void deleteUser(String username) {

    }

    @Override
    public void changePassword(String oldPassword, String newPassword) {

    }

    @Override
    public boolean userExists(String username) {
        return findByUsername(username) != null;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return findByUsername(username);
    }


    public User checkUserDetails(UserDetails user) {
        User newUser = null;
        if(user instanceof User) {
            newUser = (User) user;
        }
        else {
            newUser = new User();
            newUser.setUsername(user.getUsername());
            newUser.setPassword(user.getPassword());
        }
        return newUser;
    }

    User findByUsername(String username) {
       return  findOne(new Specification<User>() {
            @Override
            public Predicate toPredicate(Root<User> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
                return null;
            }
        });
    }
}
