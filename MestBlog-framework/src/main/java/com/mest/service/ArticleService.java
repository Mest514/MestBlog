package com.mest.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.mest.domain.ResponseResult;
import com.mest.domain.dto.AddArticleDto;
import com.mest.domain.entity.Article;
import com.mest.domain.vo.ArticleListVo;
import com.mest.domain.vo.PageVo;

import java.util.List;

public interface ArticleService extends IService<Article> {

    ResponseResult hotArticleList();

    ResponseResult articleList(Integer pageNum, Integer pageSize, Long categoryId);

    ResponseResult getArticleDetail(Long id);

    ResponseResult updateViewCount(Long id);


    ResponseResult add(AddArticleDto article);

    ResponseResult<PageVo> articleAllList(ArticleListVo articleListVo, Integer pageNum, Integer pageSize);

    ResponseResult deleteArticle(List<Long> id);

    ResponseResult<AddArticleDto> updateArticleById(Long id);

    ResponseResult updateArticle(Article article);
}
