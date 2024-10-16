/*******************************************************************************
 * Copyright (c) 2017 IBM Corporation and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License 2.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-2.0/
 * 
 * SPDX-License-Identifier: EPL-2.0
 *
 * Contributors:
 *     IBM Corporation - initial API and implementation
 *******************************************************************************/
_MF_CLS(_PFX_UTIL+"_HtmlStripper",_MF_OBJECT,{parse:function(O,M){var N="html",E=-1,B=-1,A=-1,F=-1,H=0,L=1,M=(!M)?N:M;var J=O.indexOf("<"+M);var D=this;var P=function(T,S,R,Q){return T<=S&&R<=Q;};var C=function(S,Q){var V=S.substring(Q),T=D._Lang.hitch(V,V.indexOf),W=T("<!--"),U=T("-->"),X=T("<[CDATA["),R=T("]]>");if(P(W,U,X,R)){return true;}return W<=U&&X<=R;};var G=function(S,Q){var V=S.substring(Q),U=D._Lang.hitch(V,V.indexOf),R=U("<!--"),T=U("-->"),X=U("<[CDATA["),W=U("]]>");if(P(R,T,X,W)){return true;}};var I=this._Lang.hitch(O,O.substring);while(A==-1&&J!=-1){if(G(O,J)){E=J;A=J+I(J).indexOf(">")+1;}J=I(J+M.length+2).indexOf("<"+M);}var K=O.lastIndexOf("</"+M);while(F==-1&&K>0){if(C(O,K)){B=K;F=K;}J=I(J-M.length-2).lastIndexOf("</"+M);}if(A!=-1&&F!=-1){return I(A,F);}return null;}});