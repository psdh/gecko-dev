/* -*- Mode: C++; tab-width: 2; indent-tabs-mode: nil; c-basic-offset: 4 -*-
 *
 * The contents of this file are subject to the Netscape Public License
 * Version 1.0 (the "NPL"); you may not use this file except in
 * compliance with the NPL.  You may obtain a copy of the NPL at
 * http://www.mozilla.org/NPL/
 *
 * Software distributed under the NPL is distributed on an "AS IS" basis,
 * WITHOUT WARRANTY OF ANY KIND, either express or implied. See the NPL
 * for the specific language governing rights and limitations under the
 * NPL.
 *
 * The Initial Developer of this code under the NPL is Netscape
 * Communications Corporation.  Portions created by Netscape are
 * Copyright (C) 1998 Netscape Communications Corporation.  All Rights
 * Reserved.
 */

#ifndef nsIOService_h__
#define nsIOService_h__

#include "nsIIOService.h"

class nsIOService : public nsIIOService
{
public:
    NS_DECL_ISUPPORTS

    // nsIIOService methods:
    NS_IMETHOD GetProtocolHandler(const char *scheme,
                                  nsIProtocolHandler **_retval);
    NS_IMETHOD MakeAbsolute(const char *aRelativeSpec,
                            nsIURI *aBaseURI,
                            char **_retval);
    NS_IMETHOD NewURI(const char *aSpec, nsIURI *aBaseURI,
                      nsIURI **_retval);
    NS_IMETHOD NewChannelFromURI(const char* verb, nsIURI *aURI,
                                 nsIEventSinkGetter *eventSinkGetter,
                                 nsIChannel **_retval);
    NS_IMETHOD NewChannel(const char* verb, const char *aSpec,
                          nsIURI *aBaseURI,
                          nsIEventSinkGetter *eventSinkGetter,
                          nsIChannel **_retval);
    NS_IMETHOD GetAppCodeName(nsIString * *aAppCodeName);
    NS_IMETHOD GetAppVersion(nsIString * *aAppVersion);
    NS_IMETHOD GetAppName(nsIString * *aAppName);
    NS_IMETHOD GetLanguage(nsIString * *aLanguage);
    NS_IMETHOD GetPlatform(nsIString * *aPlatform);
    NS_IMETHOD GetUserAgent(nsIString * *aUserAgent);

    // nsIOService methods:
    nsIOService();
    virtual ~nsIOService();

    static NS_METHOD
    Create(nsISupports *aOuter, REFNSIID aIID, void **aResult);

    nsresult Init();

protected:

};

#endif // nsIOService_h__
