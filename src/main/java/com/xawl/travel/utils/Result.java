package com.xawl.travel.utils;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.List;

/**
 * Created Administrator on 2017/11/17.
 */
public class Result {

    /**
     * 自定义响应体结构
     *
     * @author Administrator
     *
     */
    // 定义jackson对象
    private static final ObjectMapper MAPPER = new ObjectMapper();

        private Integer status;
        private String msg;
        private Object data;

        public Result() {
        }

        public Result(Integer status, String msg, Object data) {
            this.status = status;
            this.msg = msg;
            this.data = data;
        }

        public static Result success() {
            return new Result(200, "操作成功", null);
        }

        public static Result success(String msg) {
            return new Result(200, msg, null);
        }

        public static Result success(Object data) {
            return new Result(200, "操作成功", data);
        }

        public static Result success(String msg, Object data) {
            return new Result(200, msg, data);
        }

        public static Result fail(String msg) {
            return new Result(400, msg, null);
        }

        public static Result fail(Integer status, String msg) {
            return new Result(status, msg, null);
        }

        public Object getData() {
            return data;
        }

        public void setData(Object data) {
            this.data = data;
        }

        public String getMsg() {
            return msg;
        }

        public void setMsg(String msg) {
            this.msg = msg;
        }

        public Integer getStatus() {
            return status;
        }

        public void setStatus(Integer status) {
            this.status = status;
        }


    // 自定义无数据
    public static Result build(Integer status, String msg) {
        return new Result(status, msg, null);
    }

    // 自定义有数据
    public static Result build(Integer status, String msg, Object data) {
        return new Result(status, msg, data);
    }

    // 数据格式转换的一些方法

    /**
     * 将json结果集转化为TaotaoResult对象
     *
     * @param jsonData
     *            json数据
     * @param clazz
     *            TaotaoResult中的object类型
     * @return
     */
    public static Result formatToPojo(String jsonData, Class<?> clazz) {
        try {

            if (clazz == null) {
                return MAPPER.readValue(jsonData, Result.class);
            }
            JsonNode jsonNode = MAPPER.readTree(jsonData);
            JsonNode data = jsonNode.get("data");
            Object obj = null;

            if (clazz != null) {
                if (data.isObject()) {
                    obj = MAPPER.readValue(data.traverse(), clazz);
                } else if (data.isTextual()) {
                    obj = MAPPER.readValue(data.asText(), clazz);
                }
            }
            return build(jsonNode.get("status").intValue(), jsonNode.get("msg")
                    .asText(), obj);
        } catch (Exception e) {
            return null;
        }
    }

    /**
     * 没有object对象的转化
     *
     * @param json
     * @return
     */
    public static Result format(String json) {
        try {
            return MAPPER.readValue(json, Result.class);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * Object是集合转化
     *
     * @param jsonData
     *            json数据
     * @param clazz
     *            集合中的类型
     * @return
     */
    public static Result formatToList(String jsonData, Class<?> clazz) {
        try {
            JsonNode jsonNode = MAPPER.readTree(jsonData);
            JsonNode data = jsonNode.get("data");
            Object obj = null;
            if (data.isArray() && data.size() > 0) {
                obj = MAPPER.readValue(data.traverse(), MAPPER.getTypeFactory()
                        .constructCollectionType(List.class, clazz));
            }
            return build(jsonNode.get("status").intValue(), jsonNode.get("msg")
                    .asText(), obj);
        } catch (Exception e) {
            return null;
        }

    }

    @Override
    public String toString() {
        return "Result [status=" + status + ", msg=" + msg + ", data=" + data + "]";
    }
}







