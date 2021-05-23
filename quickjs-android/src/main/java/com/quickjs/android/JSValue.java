package com.quickjs.android;

public class JSValue {
    protected JSContext context;
    protected long objectHandle;
    protected boolean released;

    protected void initialize(long contextPtr, Object data) {
        long objectHandle = this.context.initNewJSObject(contextPtr);
        this.released = false;
        this.addObjectReference(objectHandle);
    }

    private void addObjectReference(long objectHandle) {
        this.objectHandle = objectHandle;
        // TODO 考虑自动管理
    }

    long getContextPtr() {
        return context.getContextPtr();
    }

    public void close() {
        QuickJS._release(getContextPtr(), this.objectHandle);
    }
}
