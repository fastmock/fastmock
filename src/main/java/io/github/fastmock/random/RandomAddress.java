package io.github.fastmock.random;

import io.github.fastmock.Area;
import io.github.fastmock.RegionDict;
import io.github.fastmock.utils.RandomUtils;

import java.util.List;

/**
 * Created by wangkun23 on 2022/1/3
 *
 * @version : v1.0.0
 **/
public class RandomAddress {

    private final RegionDict regionDict;

    public RandomAddress() {
        this.regionDict = new RegionDict();
    }

    private final String[] areas = {
            "东北", "华北", "华东", "华中", "华南", "西南", "西北"
    };

    /**
     * 随机生成一个大区
     *
     * @return region
     */
    public String region() {
        int anInt = RandomUtils.nextInt(0, areas.length);
        return areas[anInt];
    }

    /**
     * 随机生成一个（中国）省（或直辖市、自治区、特别行政区）
     *
     * @return province
     */
    public String province() {
        List<Area> provinces = this.regionDict.load();
        int anInt = RandomUtils.nextInt(0, provinces.size());
        Area province = provinces.get(anInt);
        return province.getName();
    }

    /**
     * 随机生成一个（中国）市(区)
     *
     * @param prefix prefix
     * @return city city
     */
    public String city(boolean prefix) {
        // 先随机省份
        int anInt = RandomUtils.nextInt(0, areas.length);
        List<Area> provinces = this.regionDict.load();
        Area province = provinces.get(anInt);

        // 城市
        List<Area> cityList = province.getChildren();
        int cityAnInt = RandomUtils.nextInt(0, cityList.size());
        Area city = cityList.get(cityAnInt);
        String fullName = province.getName() + " " + city.getName();
        return prefix ? fullName : city.getName();
    }

    /**
     * 随机生成一个（中国）县
     *
     * @param prefix prefix
     * @return county
     */
    public String county(boolean prefix) {
        // 先随机省份
        int anInt = RandomUtils.nextInt(0, areas.length);
        List<Area> provinces = this.regionDict.load();
        Area province = provinces.get(anInt);

        // 城市
        List<Area> cityList = province.getChildren();
        int cityAnInt = RandomUtils.nextInt(0, cityList.size());
        Area city = cityList.get(cityAnInt);

        // 县级
        List<Area> countyList = city.getChildren();
        int countyAnInt = RandomUtils.nextInt(0, countyList.size());
        Area county = countyList.get(countyAnInt);

        String fullName = province.getName() + " " + city.getName() + " " + county.getName();
        return prefix ? fullName : county.getName();
    }

    /**
     * 随机生成一个邮政编码（六位数字）
     *
     * @param len len
     * @return zip
     */
    public String zip(int len) {
        if (len == 0) {
            len = 6;
        }
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < len; i++) {
            builder.append(RandomBasic.nextNatural(0, 9));
        }
        return builder.toString();
    }
}
