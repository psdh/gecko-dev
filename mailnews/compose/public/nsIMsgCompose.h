/*
 * DO NOT EDIT.  THIS FILE IS GENERATED FROM nsIMsgCompose.idl
 */

#ifndef __gen_nsIMsgCompose_h__
#define __gen_nsIMsgCompose_h__

#include "nsISupports.h" /* interface nsISupports */
#include "nsIMsgCompFields.h" /* interface nsIMsgCompFields */
#include "nsID.h" /* interface nsID */

#ifdef XPIDL_JS_STUBS
#include "jsapi.h"
#endif

/* starting interface nsIMsgCompose */

/* {4E606270-B588-11D2-8289-00805F2A0107} */
#define NS_IMSGCOMPOSE_IID_STR "4E606270-B588-11D2-8289-00805F2A0107"
#define NS_IMSGCOMPOSE_IID \
  {0x4E606270, 0xB588, 0x11D2, \
    { 0x82, 0x89, 0x00, 0x80, 0x5F, 0x2A, 0x01, 0x07 }}

class nsIMsgCompose : public nsISupports {
 public: 
  static const nsIID& GetIID() {
    static nsIID iid = NS_IMSGCOMPOSE_IID;
    return iid;
  }

#ifdef XPIDL_JS_STUBS
  static NS_EXPORT_(JSObject *) InitJSClass(JSContext *cx);
  static NS_EXPORT_(JSObject *) GetJSObject(JSContext *cx, nsIMsgCompose *priv);
#endif
};

#endif /* __gen_nsIMsgCompose_h__ */
