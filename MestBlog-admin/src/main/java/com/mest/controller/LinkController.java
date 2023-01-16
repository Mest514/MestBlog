package com.mest.controller;

import com.mest.domain.ResponseResult;
import com.mest.domain.entity.Link;
import com.mest.domain.vo.LinkVo;
import com.mest.domain.vo.PageVo;
import com.mest.service.LinkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @program: MestBlog
 * @description:
 * @author: Mest
 * @create: 2023-01-15 21:32
 **/
@RestController
@RequestMapping("/content/link")
public class LinkController {

    @Autowired
    private LinkService linkService;

    @GetMapping("list")
    public ResponseResult<PageVo> list(LinkVo linkVo, Integer pageNum, Integer pageSize) {
        return linkService.selectAllLinks(linkVo, pageNum, pageSize);
    }

    @DeleteMapping("/{id}")
    public ResponseResult deleteByIs(@PathVariable("id") List<Long> id) {
        return linkService.deleteByIs(id);
    }

    @GetMapping("/{id}")
    public ResponseResult updateByIs(@PathVariable("id") Long id) {
        return linkService.selectByIs(id);
    }

    @PutMapping()
    public ResponseResult confirm(@RequestBody LinkVo linkVo) {
        return ResponseResult.okResult(linkService.updateLink(linkVo));
    }

    @PutMapping("changeLinkStatus")
    public ResponseResult changeLinkStatus(@RequestBody Link link) {
        return linkService.updateLinkStatus(link);
    }
}
