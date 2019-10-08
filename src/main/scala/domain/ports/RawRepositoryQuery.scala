package net.kgtkr.twitter_tools.domain.ports;

import net.kgtkr.twitter_tools.domain.models.AppError
import cats.data.EitherT
import net.kgtkr.twitter_tools.domain.models.Raw
import net.kgtkr.twitter_tools.domain.models.RawId

trait RawRepositoryQuery[F[_]] {
  type Result[A] = EitherT[F, AppError[Any, Nothing], A]

  def findLatest[A <: Raw](
      ids: List[A#I]
  ): Result[List[A]]
}

object RawRepositoryQuery {
  def apply[F[_]](implicit x: RawRepositoryQuery[F]): RawRepositoryQuery[F] =
    x
}
