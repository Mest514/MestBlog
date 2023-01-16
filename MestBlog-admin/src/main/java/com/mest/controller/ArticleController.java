package com.mest.controller;

import com.mest.domain.ResponseResult;
import com.mest.domain.dto.AddArticleDto;
import com.mest.domain.dto.TagListDto;
import com.mest.domain.entity.Article;
import com.mest.domain.vo.ArticleListVo;
import com.mest.domain.vo.PageVo;
import com.mest.service.ArticleService;
import com.mest.service.ArticleTagService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @program: MestBlog
 * @description: 后台admin文章接口
 * @author: Mest
 * @create: 2023-01-13 12:05
 **/
@RestController
@RequestMapping("/content/article")
public class ArticleController {

    @Autowired
    private ArticleService articleService;

    /**
     * 写博文
     */
    @PostMapping
    public ResponseResult add(@RequestBody AddArticleDto article) {
        return articleService.add(article);
    }

    /**
     * 后台展示文章管理列表
     */
    @GetMapping("list")
    public ResponseResult<PageVo> list(Integer pageNum, Integer pageSize, ArticleListVo articleListVo) {
        return articleService.articleAllList(articleListVo, pageNum, pageSize);
    }

    /**
     * 删除接口
     */
    @DeleteMapping("/{id}")
    public ResponseResult deleteArticle(@PathVariable("id") List<Long> id) {
        return articleService.deleteArticle(id);
    }

    /**
     * 文章管理修改接口—查询
     */
    @GetMapping("/{id}")
    public ResponseResult<AddArticleDto> updateArticleById(@PathVariable("id") Long id) {
        return articleService.updateArticleById(id);
    }

    /**
     * 文章管理修改接口—确认修改
     */
    @PutMapping()
    public ResponseResult confirm(@RequestBody Article article) {
        return articleService.updateArticle(article);
    }

}
