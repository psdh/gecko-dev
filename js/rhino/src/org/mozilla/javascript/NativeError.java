/* -*- Mode: java; tab-width: 8; indent-tabs-mode: nil; c-basic-offset: 4 -*-
 *
 * The contents of this file are subject to the Netscape Public
 * License Version 1.1 (the "License"); you may not use this file
 * except in compliance with the License. You may obtain a copy of
 * the License at http://www.mozilla.org/NPL/
 *
 * Software distributed under the License is distributed on an "AS
 * IS" basis, WITHOUT WARRANTY OF ANY KIND, either express or
 * implied. See the License for the specific language governing
 * rights and limitations under the License.
 *
 * The Original Code is Rhino code, released
 * May 6, 1999.
 *
 * The Initial Developer of the Original Code is Netscape
 * Communications Corporation.  Portions created by Netscape are
 * Copyright (C) 1997-1999 Netscape Communications Corporation. All
 * Rights Reserved.
 *
 * Contributor(s):
 * Igor Bukanov
 * Roger Lawrence
 *
 * Alternatively, the contents of this file may be used under the
 * terms of the GNU Public License (the "GPL"), in which case the
 * provisions of the GPL are applicable instead of those above.
 * If you wish to allow use of your version of this file only
 * under the terms of the GPL and not to allow others to use your
 * version of this file under the NPL, indicate your decision by
 * deleting the provisions above and replace them with the notice
 * and other provisions required by the GPL.  If you do not delete
 * the provisions above, a recipient may use your version of this
 * file under either the NPL or the GPL.
 */


package org.mozilla.javascript;

/**
 *
 * The class of error objects
 *
 *  ECMA 15.11
 */
final class NativeError extends IdScriptable
{

    static void init(Context cx, Scriptable scope, boolean sealed)
    {
        NativeError obj = new NativeError();
        obj.prototypeFlag = true;
        obj.messageValue = "";
        obj.nameValue = "Error";
        obj.addAsPrototype(MAX_PROTOTYPE_ID, cx, scope, sealed);
    }

    protected String toSource(Context cx, Scriptable scope, Object[] args)
        throws JavaScriptException
    {
        Object value = messageValue;
        if (value == NOT_FOUND)
            return "(new Error())";
        String str = ScriptRuntime.toString(value);
        str = ScriptRuntime.escapeString(str);
        return "(new Error(\""+str+"\"))";
    }

    protected int getIdAttributes(int id)
    {
        if (id == Id_message || id == Id_name) { return EMPTY; }
        return super.getIdAttributes(id);
    }

    protected boolean hasIdValue(int id)
    {
        if (id == Id_message) { return messageValue != NOT_FOUND; }
        if (id == Id_name) { return nameValue != NOT_FOUND; }
        return super.hasIdValue(id);
    }

    protected Object getIdValue(int id)
    {
        if (id == Id_message) { return messageValue; }
        if (id == Id_name) { return nameValue; }
        return super.getIdValue(id);
    }

    protected void setIdValue(int id, Object value)
    {
        if (id == Id_message) { messageValue = value; return; }
        if (id == Id_name) { nameValue = value; return; }
        super.setIdValue(id, value);
    }

    protected void deleteIdValue(int id)
    {
        if (id == Id_message) { messageValue = NOT_FOUND; return; }
        if (id == Id_name) { nameValue = NOT_FOUND; return; }
        super.deleteIdValue(id);
    }

    public int methodArity(int methodId)
    {
        if (prototypeFlag) {
            if (methodId == Id_constructor) return 1;
            if (methodId == Id_toString) return 0;
        }
        return super.methodArity(methodId);
    }

    public Object execMethod
        (int methodId, IdFunction f,
         Context cx, Scriptable scope, Scriptable thisObj, Object[] args)
        throws JavaScriptException
    {
        if (prototypeFlag) {
            if (methodId == Id_constructor) {
                NativeError result = new NativeError();
                if (args.length >= 1)
                    result.messageValue = ScriptRuntime.toString(args[0]);
                result.setPrototype(getClassPrototype(scope, "Error"));
                return result;
            }
            else if (methodId == Id_toString) {
                return js_toString(thisObj);
            }
        }
        return super.execMethod(methodId, f, cx, scope, thisObj, args);
    }

    private static String js_toString(Scriptable thisObj)
    {
        return getName(thisObj)+": "+getMessage(thisObj);
    }

    public String getClassName()
    {
        return "Error";
    }

    public String toString()
    {
        return js_toString(this);
    }

    private static String getName(Scriptable obj)
    {
        Object value = ScriptRuntime.getStrIdElem(obj, "name");
        return ScriptRuntime.toString(value);
    }

    private static String getMessage(Scriptable obj)
    {
        Object value = ScriptRuntime.getStrIdElem(obj, "message");
        return ScriptRuntime.toString(value);
    }

    protected String getIdName(int id)
    {
        if (id == Id_message) { return "message"; }
        if (id == Id_name) { return "name"; }
        if (prototypeFlag) {
            if (id == Id_constructor) return "constructor";
            if (id == Id_toString) return "toString";
        }
        return null;
    }

// #string_id_map#

    private static final int
        Id_message               = 1,
        Id_name                  = 2,

        MAX_INSTANCE_ID          = 2;

    { setMaxId(MAX_INSTANCE_ID); }

    protected int mapNameToId(String s)
    {
        int id;
// #generated# Last update: 2001-05-19 21:55:23 CEST
        L0: { id = 0; String X = null;
            int s_length = s.length();
            if (s_length==4) { X="name";id=Id_name; }
            else if (s_length==7) { X="message";id=Id_message; }
            if (X!=null && X!=s && !X.equals(s)) id = 0;
        }
// #/generated#
// #/string_id_map#

        if (id != 0 || !prototypeFlag) { return id; }

// #string_id_map#
// #generated# Last update: 2001-05-19 21:55:23 CEST
        L0: { id = 0; String X = null;
            int s_length = s.length();
            if (s_length==8) { X="toString";id=Id_toString; }
            else if (s_length==11) { X="constructor";id=Id_constructor; }
            if (X!=null && X!=s && !X.equals(s)) id = 0;
        }
// #/generated#
        return id;
    }

    private static final int
        Id_constructor    = MAX_INSTANCE_ID + 1,
        Id_toString       = MAX_INSTANCE_ID + 2,

        MAX_PROTOTYPE_ID  = MAX_INSTANCE_ID + 2;

// #/string_id_map#

    private Object messageValue = NOT_FOUND;
    private Object nameValue = NOT_FOUND;

    private boolean prototypeFlag;
}
