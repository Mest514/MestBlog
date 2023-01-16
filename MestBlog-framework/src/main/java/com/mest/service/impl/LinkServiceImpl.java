package com.mest.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.mest.constants.SystemConstants;
import com.mest.domain.ResponseResult;
import com.mest.domain.entity.Link;
import com.mest.domain.vo.LinkVo;
import com.mest.domain.vo.PageVo;
import com.mest.mapper.LinkMapper;
import com.mest.service.LinkService;
import com.mest.utils.BeanCopyUtils;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.List;

/**
 * 友链(Link)表服务实现类
 *
 * @author makejava
 * @since 2022-12-29 17:11:38
 */
@Service("linkService")
public class LinkServiceImpl extends ServiceImpl<LinkMapper, Link> implements LinkService {

    @Override
    public ResponseResult getAllLinks() {
        //查询所有审核通过的
        LambdaQueryWrapper<Link> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(Link::getStatus, SystemConstants.LINK_STATUS_NORMAL);
        List<Link> links = list(queryWrapper);
        //转换vo
        List<LinkVo> linkVos = BeanCopyUtils.copyBeanList(links, LinkVo.class);
        //封装返回
        return ResponseResult.okResult(linkVos);
    }

    @Override
    public ResponseResult<PageVo> selectAllLinks(LinkVo linkVo, Integer pageNum, Integer pageSize) {
        //分页
        LambdaQueryWrapper<Link> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.like(StringUtils.hasText(linkVo.getName()), Link::getName, linkVo.getName());
        queryWrapper.like(StringUtils.hasText(linkVo.getStatus()), Link::getStatus, linkVo.getStatus());

        Page page = new Page();
        page.setCurrent(pageNum);
        page.setSize(pageSize);
        page(page, queryWrapper);
        //封装数据
        PageVo pageVo = new PageVo(page.getRecords(), page.getTotal());
        return ResponseResult.okResult(pageVo);
    }

    @Override
    public ResponseResult deleteByIs(List<Long> id) {
        removeByIds(id);
        return ResponseResult.okResult();
    }

    @Override
    public ResponseResult selectByIs(Long id) {
        Link link = getById(id);
        return ResponseResult.okResult(link);
    }

    @Override
    public ResponseResult updateLink(LinkVo linkVo) {
        Link link = BeanCopyUtils.copyBean(linkVo, Link.class);
        updateById(link);
        return ResponseResult.okResult();
    }

    @Override
    public ResponseResult updateLinkStatus(Link link) {
        updateById(link);
        return ResponseResult.okResult();
    }
}

