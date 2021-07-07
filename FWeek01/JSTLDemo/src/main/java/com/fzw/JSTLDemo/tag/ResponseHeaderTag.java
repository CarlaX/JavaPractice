package com.fzw.JSTLDemo.tag;

import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.jsp.JspException;
import jakarta.servlet.jsp.tagext.BodyTagSupport;

/**
 * @author fzw
 * @description
 * @date 2021-07-07
 **/
public class ResponseHeaderTag extends BodyTagSupport {

    private String cacheControl;
    private String pragma;
    private Long expires;

    @Override
    public int doStartTag() throws JspException {
        System.out.println("doStartTag: " + this.cacheControl);
        System.out.println(this.pageContext.getResponse().getClass().getName());
        System.out.println(this.pageContext.getResponse() instanceof HttpServletResponse);
        HttpServletResponse response = (HttpServletResponse) this.pageContext.getResponse();
        response.setHeader("Cache-Control", this.cacheControl);
        response.setHeader("Pragma", this.pragma);
        response.setHeader("Expires", this.expires.toString());
        return super.doStartTag();
    }

    @Override
    public void doInitBody() throws JspException {
        System.out.println("doInitBody: " + this.cacheControl);
        super.doInitBody();
    }

    @Override
    public int doAfterBody() throws JspException {
        System.out.println("doAfterBody: " + this.cacheControl);
        return super.doAfterBody();
    }

    @Override
    public int doEndTag() throws JspException {
        System.out.println("doEndTag: " + this.cacheControl);
        return super.doEndTag();
    }

    public void setCacheControl(String cacheControl) {
        this.cacheControl = cacheControl;
    }

    public void setPragma(String pragma) {
        this.pragma = pragma;
    }

    public void setExpires(Long expires) {
        this.expires = expires;
    }
}
