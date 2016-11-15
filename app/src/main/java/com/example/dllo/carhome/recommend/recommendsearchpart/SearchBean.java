package com.example.dllo.carhome.recommend.recommendsearchpart;

import java.util.List;

/**
 * Created by dllo on 16/11/15.
 */
public class SearchBean {


    /**
     * returncode : 0
     * message :
     * result : {"pageindex":1,"pagesize":0,"pagecount":1,"rowcount":10,"wordlist":[{"id":0,"name":"华晨宝马"},{"id":0,"name":"汉腾汽车"},{"id":2123,"name":"哈弗H6"},{"id":771,"name":"汉兰达"},{"id":3074,"name":"哈弗H7"},{"id":4168,"name":"哈弗H2s"},{"id":2615,"name":"哈弗H2"},{"id":3518,"name":"撼路者"},{"id":4130,"name":"汉腾X7"},{"id":882,"name":"皇冠"}]}
     */

    private int returncode;
    private String message;
    /**
     * pageindex : 1
     * pagesize : 0
     * pagecount : 1
     * rowcount : 10
     * wordlist : [{"id":0,"name":"华晨宝马"},{"id":0,"name":"汉腾汽车"},{"id":2123,"name":"哈弗H6"},{"id":771,"name":"汉兰达"},{"id":3074,"name":"哈弗H7"},{"id":4168,"name":"哈弗H2s"},{"id":2615,"name":"哈弗H2"},{"id":3518,"name":"撼路者"},{"id":4130,"name":"汉腾X7"},{"id":882,"name":"皇冠"}]
     */

    private ResultBean result;

    public int getReturncode() {
        return returncode;
    }

    public void setReturncode(int returncode) {
        this.returncode = returncode;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public ResultBean getResult() {
        return result;
    }

    public void setResult(ResultBean result) {
        this.result = result;
    }

    public static class ResultBean {
        private int pageindex;
        private int pagesize;
        private int pagecount;
        private int rowcount;
        /**
         * id : 0
         * name : 华晨宝马
         */

        private List<WordlistBean> wordlist;

        public int getPageindex() {
            return pageindex;
        }

        public void setPageindex(int pageindex) {
            this.pageindex = pageindex;
        }

        public int getPagesize() {
            return pagesize;
        }

        public void setPagesize(int pagesize) {
            this.pagesize = pagesize;
        }

        public int getPagecount() {
            return pagecount;
        }

        public void setPagecount(int pagecount) {
            this.pagecount = pagecount;
        }

        public int getRowcount() {
            return rowcount;
        }

        public void setRowcount(int rowcount) {
            this.rowcount = rowcount;
        }

        public List<WordlistBean> getWordlist() {
            return wordlist;
        }

        public void setWordlist(List<WordlistBean> wordlist) {
            this.wordlist = wordlist;
        }

        public static class WordlistBean {
            private int id;
            private String name;

            public int getId() {
                return id;
            }

            public void setId(int id) {
                this.id = id;
            }

            public String getName() {
                return name;
            }

            public void setName(String name) {
                this.name = name;
            }
        }
    }
}
