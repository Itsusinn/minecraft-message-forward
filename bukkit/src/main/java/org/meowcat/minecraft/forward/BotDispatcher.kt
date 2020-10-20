package org.meowcat.minecraft.forward

import net.mamoe.mirai.Bot
import net.mamoe.mirai.containsGroup
import org.meowcat.minecraft.forward.data.ConfigService

/**
 * 一个bot调度器
 * 决定哪个监听监听
 * 哪些bot进行发送
 * 还负责校检合法性
 */
object BotDispatcher{
    val allBots = HashSet<Bot>()
    val speakers = HashSet<Bot>()
    var listener = 12345678L
    var target = 12345678L

    fun reDispatch(){
        changeTarget(this.target)
    }

    fun addBot(bot: Bot):BotDispatcher{
        allBots.add(bot)
        reDispatch()
        return this
    }

    fun changeTarget(target:Long){
        this.target = target
        if (allBots.isEmpty()) return
        //清除speaker
        speakers.clear()
        allBots.forEach {
            it.containsGroup(target)
            speakers.add(it)
        }
        listener = speakers.random().id
        ConfigService.config.target = target
    }

    fun findBotByID(id:Long):Bot?{
        allBots.forEach {
            if (it.id == id) return it
        }
        return null
    }
}