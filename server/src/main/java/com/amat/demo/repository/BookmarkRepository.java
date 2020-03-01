package com.amat.demo.repository;

import com.amat.demo.dto.Bookmark;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface BookmarkRepository extends JpaRepository<Bookmark, Long> {

    @Query("from Bookmark b where b.username=:username")
    public Iterable<Bookmark> findBookmarksByUsername(@Param("username") String username);

    @Query("from Bookmark b where b.username=:username and b.repo_url=:repoUrl")
    public Optional<Bookmark> findByUsernameAndRepoUrl(@Param("username") String username, @Param("repoUrl") String repoUrl);

}
