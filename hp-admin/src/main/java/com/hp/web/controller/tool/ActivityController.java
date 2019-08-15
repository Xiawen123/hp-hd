package com.hp.web.controller.tool;

import com.alibaba.fastjson.JSON;
import com.hp.activity.domain.*;
import com.hp.activity.service.*;
import com.hp.common.annotation.Log;
import com.hp.common.base.AjaxResult;
import com.hp.common.base.Rs;
import com.hp.common.enums.BusinessType;
import com.hp.common.page.TableDataInfo;
import com.hp.common.snowflake.SnowFlake;
import com.hp.common.utils.AesCbcUtil;
import com.hp.common.utils.FastJsonUtils;
import com.hp.framework.web.base.BaseController;
import com.hp.web.controller.activity.HdPlayerTicketLogController;
import com.hp.web.controller.system.cloud.CloudStorageService;
import com.hp.web.controller.system.cloud.OSSFactory;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import net.sf.json.JSONObject;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.stream.Stream;

/**
 * 活动小程序接口
 */
@Api("活动小程序端信息管理")
@RestController
@RequestMapping("/applet/activity")
public class ActivityController extends BaseController {

    @Autowired
    private IHdPlayerService hdPlayerService;

    @Autowired
    private IHdPlayerImgService hdPlayerImgService;

    @Autowired
    private IHdActivityService hdActivityService;

    @Autowired
    private IHdCoverService hdCoverService;

    @Autowired
    private IHdPlayerTicketLogService hdPlayerTicketLogService;

    @Autowired
    private IHdGiftService hdGiftService;

    @Autowired
    private IHdPlayerGiftLogService hdPlayerGiftLogService;

    @Autowired
    private IHdGroupService hdGroupService;

    @Autowired
    private IHdInfoService hdInfoService;

    @Autowired
    private IHdQuestionnaireGiftService hdQuestionnaireGiftService;

    @Autowired
    private IHdInfogiftlogService hdInfogiftlogService;

    @ApiOperation("活动详情页")
    @PostMapping("/list")
    @ResponseBody
    public Rs list(HdPlayer hdPlayer) throws ParseException {

        return Rs.success();
    }

    @ApiOperation("活动详情页选手列表")
    @PostMapping("/activityPlayer")
    @ResponseBody
    public TableDataInfo activityPlayer(HdPlayer hdPlayer)
    {

        List<HdPlayer> playerList = new ArrayList<>();
        return getDataTable(playerList);
    }

    @ApiOperation("条件查询选手列表")
    @PostMapping("/playerList")
    @ResponseBody
    public Rs playerList(HdPlayer hdPlayer)
    {

        return Rs.success();
    }

    @ApiOperation("查询活动简介")
    @PostMapping("/introduction")
    @ResponseBody
    public Rs introduction(HdActivity hdActivity)
    {

        return Rs.success();
    }

    @ApiOperation("查询选手详情")
    @PostMapping("/player")
    @ResponseBody
    public Rs player(HdPlayer hdPlayer)
    {

        return Rs.success();
    }

    @ApiOperation("新增保存选手")
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(HdPlayer hdPlayer)
    {

            return toAjax(0);


    }

    @ApiOperation("选手排行版")
    @PostMapping("/playerRank")
    @ResponseBody
    public Rs playerRank(HdPlayer hdPlayer)
    {

        return Rs.success();
    }

    @ApiOperation("投票")
    @PostMapping("/vote")
    @ResponseBody
    public Rs vote(HdPlayerTicketLog hdPlayerTicketLog)
    {

            return Rs.faild();

    }

    @ApiOperation("选手送礼物页面")
    @PostMapping("/giftList")
    @ResponseBody
    public Rs giftList(HdPlayer hdPlayer)
    {

        return Rs.success();
    }

    @ApiOperation("送礼成功加票")
    @PostMapping("/giftVote")
    @ResponseBody
    public Rs giftVote(HdPlayerGiftLog hdPlayerGiftLog)
    {

            return Rs.faild();

    }

    /**
     *微信登录
     * @param code 凭证
     * @return map
     */
    @PostMapping("/getAppid")
    @ResponseBody
    public Rs loginByWeixin(String code)
    {
        String sendGet=hdGiftService.loginByWeixin(code); //根据code去调用接口获取用户openid和session_key
        JSONObject json = JSONObject.fromObject(sendGet);
        return Rs.success(json);
    }

    /**
     * 搜索小程序查询正在运行中的最火的活动编号
     * @return map
     */
    @PostMapping("/getHotActivity")
    @ResponseBody
    public Rs getHotActivity()
    {

        return Rs.success();
    }

    @ApiOperation("搜索小程序页面")
    @PostMapping("/getActivityList")
    @ResponseBody
    public Rs getActivityList()
    {

        return Rs.success();
    }

    @ApiOperation("选手详情页投票列表")
    @PostMapping("/playerTicket")
    @ResponseBody
    public TableDataInfo playerTicket(HdPlayerTicketLog hdPlayerTicketLog)
    {
        List<HdPlayerTicketLog> hdPlayerTicketLoglist = new ArrayList<>();
        return getDataTable(hdPlayerTicketLoglist);
    }

    @ApiOperation("添加选手页面分组列表")
    @PostMapping("/groupList")
    @ResponseBody
    public Rs groupList(HdGroup hdGroup)
    {

        return Rs.success();
    }


}
