/**
 * 事件：
 * 这层目录主要存放事件相关的代码。
 * 它包括两个子目录：publish 和 subscribe。
 * 前者主要存放事件发布相关代码，后者主要存放事件订阅相关代码（事件处理相关的核心业务逻辑在领域层实现）。
 * 这里提示一下：虽然应用层和领域层都可以进行事件的发布和处理，但为了实现事件的统一管理，我建议你将微服务内所有事件的发布和订阅的处理都统一放到应用层，事件相关的核心业务逻辑实现放在领域层。
 * 通过应用层调用领域层服务，来实现完整的事件发布和订阅处理流程。
 */
package com.lazy.application.event;