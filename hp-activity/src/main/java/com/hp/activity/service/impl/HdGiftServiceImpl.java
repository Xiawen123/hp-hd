package com.hp.activity.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.hp.common.utils.Httprequests;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.hp.activity.mapper.HdGiftMapper;
import com.hp.activity.domain.HdGift;
import com.hp.activity.service.IHdGiftService;
import com.hp.common.support.Convert;

/**
 * 礼物 服务层实现
 *
 * @author hp
 * @date 2019-05-31
 */
@Service
public class HdGiftServiceImpl implements IHdGiftService {
    @Autowired
    private HdGiftMapper hdGiftMapper;

    /**
     * 查询礼物信息
     *
     * @param id 礼物ID
     * @return 礼物信息
     */
    @Override
    public HdGift selectHdGiftById(Integer id) {
        return hdGiftMapper.selectHdGiftById(id);
    }

    /**
     * 查询礼物列表
     *
     * @param hdGift 礼物信息
     * @return 礼物集合
     */
    @Override
    public List<HdGift> selectHdGiftList(HdGift hdGift) {
        return hdGiftMapper.selectHdGiftList(hdGift);
    }

    /**
     * 新增礼物
     *
     * @param hdGift 礼物信息
     * @return 结果
     */
    @Override
    public int insertHdGift(HdGift hdGift) {
        return hdGiftMapper.insertHdGift(hdGift);
    }

    /**
     * 修改礼物
     *
     * @param hdGift 礼物信息
     * @return 结果
     */
    @Override
    public int updateHdGift(HdGift hdGift) {
        return hdGiftMapper.updateHdGift(hdGift);
    }

    /**
     * 删除礼物对象
     *
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteHdGiftByIds(String ids) {
        return hdGiftMapper.deleteHdGiftByIds(Convert.toStrArray(ids));
    }

    @Override
    public String loginByWeixin(String code) {
        //Map<String, Object> map = new HashMap<String, Object>();
        String url = "https://api.weixin.qq.com/sns/jscode2session";
        String Appid = "wx07c16a86468ddc2f";
        String Secret = "6e140e2d37846a02809433b1afeceff6";

        //发送    ?appid=APPID&secret=SECRET&js_code=JSCODE&grant_type=authorization_code 获取用户的openid和session_key
        //注意这个是 WeChatTool.wxspAppid 是微信小程序的appid 从微信小程序后台获取 WeChatTool.wxspSecret 这个也一样，我这里是用了常量来进行保存方便多次使用
        String params = "appid=" + Appid + "&secret=" + Secret + "&js_code=" + code + "&grant_type=authorization_code";
        String sendGet = Httprequests.sendGet(url, params); //发起请求拿到key和openid
        return sendGet;
    }

    @Override
    public String getAccctoken() {
        String url = "https://api.weixin.qq.com/cgi-bin/token";
        String Appid = "wx55f741a2d95132af";
        String Secret = "fab1dfc329c8265c134b015f30024c51";
        String params = "appid=" + Appid + "&secret=" + Secret + "&grant_type=client_credential";
        String acccc_tolen = Httprequests.sendGet(url, params); //发起请求拿到key和openid
        return acccc_tolen;
    }
}
